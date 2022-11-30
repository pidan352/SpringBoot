package com.lyl.service.impl;

import com.lyl.entity.AppVersion;
import com.lyl.mapper.AppVersionMapper;
import com.lyl.service.IAppVersionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements IAppVersionService {

}
