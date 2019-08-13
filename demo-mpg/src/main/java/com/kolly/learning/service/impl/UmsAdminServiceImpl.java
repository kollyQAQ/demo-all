package com.kolly.learning.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kolly.learning.entity.UmsAdmin;
import com.kolly.learning.mapper.UmsAdminMapper;
import com.kolly.learning.service.IUmsAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author kolly.li
 * @since 2019-08-13
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements IUmsAdminService {

}
