package com.lyl.service.impl;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyl.entity.*;
import com.lyl.mapper.SysRoleMapper;
import com.lyl.service.ISysRoleOfficeService;
import com.lyl.service.ISysRoleResourceService;
import com.lyl.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

	@Autowired
	private ISysRoleResourceService roleResourceService;

	@Autowired
	private ISysRoleOfficeService roleOfficeService;


	@Override
	public IPage<SysRoleDo> selectAll(IPage<SysRoleDo> page, Map<String, Object> params) {
		QueryWrapper<SysRoleDo> qw = new QueryWrapper<>();

		qw.apply("sr.office_id=so.id AND sr.del_flag=0")
				.eq(params.containsKey("id") && !ObjectUtils.isEmpty(params.get("id")), "sr.office_id",
					params.get("id"))
				.eq(params.containsKey("dataScope") && !ObjectUtils.isEmpty(params.get("dataScope")), "sr.data_scope",
					params.get("dataScope"))
				.like(params.containsKey("name") && !ObjectUtils.isEmpty(params.get("name")), "sr.name",
					  params.get("name"));

		return baseMapper.selectAll(page, qw);
	}

	@Override
	public List<SysUser> selectNoRole(Integer roleId, Integer oid) {
		return baseMapper.selectNoRole(roleId, oid);
	}

	@Override
	public SysRoleDo selectOne(Integer id) {
		SysRoleDo roleDo = baseMapper.selectOneById(id);
		roleDo.setResources(baseMapper.selectRoleResource(id));
		roleDo.setOffices(baseMapper.selectRoleOffice(id));
		return roleDo;
	}

	@Override
	public List<SysUser> selectByRid(Integer roleId) {

		return baseMapper.selectByRid(roleId);
	}

	@Override
	public List<SysRole> selectRoleByUserId(Long id) {
		return baseMapper.selectRoleByUserId(id);
	}

	@Override
	@Transactional
	public boolean updateById(SysRoleDo roleDo) {

		SysRole role = roleDo;

		try {
			//更改role表的数据
			super.updateById(role);

			//更改role对应的resource中间表
			List<SysResource> resources = roleDo.getResources();
			if (!ObjectUtils.isEmpty(resources)) {
				updateRoleResources(roleDo.getId(), resources);
			}

			//更改role对应的office中间表
			List<SysOffice> offices = roleDo.getOffices();
			if (!ObjectUtils.isEmpty(offices)) {
				updateRoleOffices(roleDo.getId(), offices);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private void updateRoleOffices(Long id, List<SysOffice> offices) {
		ArrayList<SysRoleOffice> list = new ArrayList<>();
		offices.forEach(office -> {
			SysRoleOffice roleOffice = new SysRoleOffice();
			roleOffice.setRoleId(id);
			roleOffice.setOfficeId(office.getId());
			list.add(roleOffice);
		});

		//删除旧数据
		roleOfficeService.remove(new QueryWrapper<SysRoleOffice>().eq("role_id", id));

		//添加新数据
		roleOfficeService.saveBatch(list);
	}

	private void updateRoleResources(Long id, List<SysResource> resources) {
		ArrayList<SysRoleResource> list = new ArrayList<>();
		resources.forEach(resource -> {
			SysRoleResource roleResource = new SysRoleResource();
			roleResource.setRoleId(id);
			roleResource.setResourceId(resource.getId());
			list.add(roleResource);
		});

		//删除旧数据
		roleResourceService.remove(new QueryWrapper<SysRoleResource>().eq("role_id", id));

		//添加新数据
		roleResourceService.saveBatch(list);
	}
}
