package com.hucs.top.model;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huchuansai
 * @Date: 2022/8/12 11:51 AM
 * @Description:
 */
@Data
public class GeneratorBo {
    /**
     * 作者
     */
    public String author;

    /**
     * 指定生成的主键的ID类型
     */
    public IdType idType;

    /**
     * 数据库url
     */
    public String dbUrl;

    /**
     * 数据库username
     */
    public String dbUsername;

    /**
     * 数据库密码
     */
    public String dbPassword;

    /**
     * 生成的数据库表
     */
    public List<String> tableNames;

    /**
     * 父包名
     */
    public String packageParent;

    /**
     * 父包名下的模块名
     */
    public String packageModel;

    /**
     * controller通用类集合
     */
    public List<String> controllerNormalObjList = new ArrayList<>();

    /**
     * manager通用类集合
     */
    public List<String> managerNormalObjList = new ArrayList<>();


    /** 以下字段都有默认值 */

    /**
     * 新增字段名
     */
    public String insertColumn = "date_created";
    /**
     * 修改字段名
     */
    public String updateColumn = "date_modify";
    /**
     * 删除字段名
     */
    public String deleteColumn = "deleted";
    /**
     * 乐观锁字段名
     */
    public String versionColumn = "version";

    /**
     * controller包名
     */
    public String packageController = "controller";

    /**
     * manager包名
     */
    public String packageManager = "manager";

    /**
     * managerImpl包名
     */
    public String packageManagerImpl = "manager.ext";

    /**
     * service包名
     */
    public String packageService = "service";

    /**
     * serviceImpl包名
     */
    public String packageServiceImpl = "service.ext";

    /**
     * dao包名
     */
    public String packageDao = "dao";

    /**
     * entity包名
     */
    public String packageEntity = "entity";

    /**
     * xml包名
     */
    public String packageXml = "mapper";

    /**
     * addParam 和 updateParam包名
     */
    public String packageParam = "model.param";

    /**
     * vo包名
     */
    public String packageVo = "model.vo";
}
