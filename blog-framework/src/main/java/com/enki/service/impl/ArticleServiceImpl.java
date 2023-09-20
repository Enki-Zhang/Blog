package com.enki.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.enki.constants.SystemCanstants;
import com.enki.domain.Article;
import com.enki.domain.Category;
import com.enki.domain.ResponseResult;
import com.enki.mapper.ArticleMapper;
import com.enki.service.CategoryService;
import com.enki.utils.BeanCopyUtils;
import com.enki.vo.ArticleDetailVo;
import com.enki.vo.ArticleListVo;
import com.enki.vo.HotArticleVO;
import com.enki.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enki.service.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Enki
 * @ClassName ArticleServiceImpl
 * @Description: TODO
 * @Date 2023/9/20 13:53
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleService articleService;

    /**
     * 选出热点文章
     *
     * @return
     */
    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT, SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page, queryWrapper);
        //获取最终的查询结果
        List<Article> articles = page.getRecords();
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);
////        将结果封装为VO
//        List<HotArticleVO> articleVos = new ArrayList<>();
//        for (Article article : articles) {
//            HotArticleVO vo = new HotArticleVO();
//            BeanUtils.copyProperties(article, vo);
//            articleVos.add(vo);
//        }

        return ResponseResult.okResult(articleVos);
    }

    /**
     * 首页查询文章列表
     *
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, lambdaQueryWrapper);
//        在结果中添加每个文章分类
        List<Article> records = page.getRecords();
        for (Article record : records) {
            Category category = categoryService.getById(record.getCategoryId());
            String name = category.getName();
            record.setCategoryName(name);
        }

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);

        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 根据id查询文章详情
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult getArticleDetail(Long id) {
        Article article = articleService.getById(id);
//        将结果封装为响应类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
//        查询分类名称
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //如果根据分类id查询的到分类名，那么就把查询到的值设置给ArticleDetailVo实体类的categoryName字段
        if (ObjectUtil.isNotNull(category)) {
            articleDetailVo.setCategoryName(category.getName());
        }
        //封装响应返回。ResponseResult是我们在huanf-framework工程的domain目录写的实体类
        return ResponseResult.okResult(articleDetailVo);

    }
}
