package com.enki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.enki.constants.SystemCanstants;
import com.enki.domain.Link;
import com.enki.domain.ResponseResult;
import com.enki.mapper.LinkMapper;
import com.enki.service.LinkService;
import com.enki.utils.BeanCopyUtils;
import com.enki.vo.LinkVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Enki
 * @ClassName LinkServiceImpl
 * @Description: TODO
 * @Date 2023/9/20 16:53
 * @Version 1.0
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
    /**
     * 查询所有审核通过的友链
     *
     * @return
     */
    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        //要求查的是友链表status字段的值为0，注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        queryWrapper.eq(Link::getStatus, SystemCanstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //把最后的查询结果封装成LinkListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);

        //封装响应返回。ResponseResult是我们在huanf-framework工程的domain目录写的实体类
        return ResponseResult.okResult(linkVos);
    }
}
