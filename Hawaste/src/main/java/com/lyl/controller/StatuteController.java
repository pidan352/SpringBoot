package com.lyl.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.entity.Statute;
import com.lyl.service.IStatuteService;
import com.lyl.utils.PageInfo;
import com.lyl.utils.ResponseStatus;
import com.lyl.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyl
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/manager/statute")
public class StatuteController {

	@Autowired
	private IStatuteService statuteService;

	/*
	分页查询
	* restful 传参分页信息  占位符与方法参数名一致可以省略
	  type:  注意页面初始化的时候默认传入空串，会导致 type 没有值  @RequestParam 会校验type，发现没有值会报错not present
	  设置required=false表示不是必须
	* */
	@RequestMapping("/select/{current}/{size}")
	public ResultBean<Page> select(@PathVariable Integer current, @PathVariable Integer size, @RequestParam(required =
			false) Integer type) {
		//自定义分页对象，扩展mybatis_plus的分页
		PageInfo<Statute> page = (PageInfo<Statute>) statuteService.selectByCondition(
				new PageInfo<Statute>(current, size), type);
		page.setNavigatePage();//设置分页导航栏数据
		return ResultBean.ok(page);
	}

	/*
	 * 查询某个statute信息
	 * */
	@RequestMapping("/selectOne")
	public ResultBean selectOne(Long id) {
		System.out.println(id);
		return ResultBean.ok(statuteService.getById(id));
	}


	/**
	 * 更新或插入   无主键是插入数据，有主键是更新
	 *
	 * @param statute
	 * @return
	 */
	@PostMapping("/saveOrUpdate")
	public ResultBean saveOrUpdate(@RequestBody Statute statute) {
		System.out.println("保存的法律：" + statute);
		statuteService.saveOrUpdate(statute);
		return ResultBean.ok();
	}

	@RequestMapping("/delete")
	public ResultBean delete(Long id) {
		System.out.println(id);
		boolean b = statuteService.removeById(id);
		if (b) {
			return ResultBean.ok();
		} else {
			return ResultBean.fail(ResponseStatus.ERROR);
		}

	}
}
