package com.hucs.top.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.hucs.top.model.GeneratorBo;
import com.hucs.top.model.PrefixKeyConstant;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class GenerateCodeUtil {
    // 要生成的数据库表，可以传入多个
    private static final List<String> tableNameList = Arrays.asList("house");
    // 作者
    private static final String AUTHOR_NAME = PrefixKeyConstant.AUTHOR;
    // 数据库连接地址：
    private static final String DATA_BASE_URL = "jdbc:mysql://114.116.219.138:3306/livecloud?useUnicode=true&useSSL=false&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
    // 数据库账号及密码
    private static final String DATA_BASE_USERNAME = "livecloud";
    private static final String DATA_BASE_PASSWORD = "admin123";
    // 数据库驱动
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";


    public static void main(String[] args) {
        GeneratorBo paramModel = new GeneratorBo();
        //需要生成的表集合
        paramModel.tableNames = tableNameList;
        paramModel.author = AUTHOR_NAME;
        paramModel.dbUrl = DATA_BASE_URL;
        paramModel.dbUsername = DATA_BASE_USERNAME;
        paramModel.dbPassword = DATA_BASE_PASSWORD;
        //父包名
        paramModel.packageParent = "com.hucs";
        //父包名下的模块名
        paramModel.packageModel = "top";

        //指定生成的主键的ID类型
        paramModel.idType = IdType.AUTO;

        //controller通用类地址声明
        paramModel.controllerNormalObjList.add("com.hucs.top.model.rest.Result");
        paramModel.controllerNormalObjList.add("com.hucs.top.model.rest.ResultGenerator");
        paramModel.controllerNormalObjList.add("com.hucs.top.model.rest.User");
        //manager通用类地址声明
        paramModel.managerNormalObjList.add("com.hucs.top.model.rest.User");

        //controller、manager\新增、修改、删除、乐观锁字段名等等均有默认值，如有其它输出位置，覆盖默认值，例如:
//        paramModel.packageController = "controller.iot";
//        paramModel.packageManagerImpl = "manager.ext.iot";
//        paramModel.packageServiceImpl = "service.ext.iot";
//        paramModel.packageParam = "model.param.iot";

        generatorCode(paramModel);
    }


    public static void generatorCode(GeneratorBo paramModel) {

        AutoGenerator mpg = new AutoGenerator();

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOpen(false);
        //####是否将上一次生成内容覆盖，谨慎改为true，true会将该表代码全部重置
        gc.setFileOverride(false);
        gc.setBaseResultMap(true); //生成resultMap
        gc.setSwagger2(true);
        gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setIdType(paramModel.idType == null ? IdType.NONE : paramModel.idType);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEntityName("");
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);


        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        if (StringUtil.isEmpty(paramModel.dbUrl)) throw new RuntimeException("数据库url必填");
        dsc.setUrl(paramModel.dbUrl);
        // 目前仅支持mysql
        dsc.setDriverName(DRIVER_CLASS_NAME);
        dsc.setUsername(paramModel.dbUsername);
        dsc.setPassword(paramModel.dbPassword);
        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(paramModel.packageParent);
        pc.setModuleName(paramModel.packageModel);
        pc.setController(paramModel.packageController);
        pc.setEntity(paramModel.packageEntity);
        pc.setMapper(paramModel.packageDao);
        pc.setService(paramModel.packageService);
        pc.setServiceImpl(paramModel.packageServiceImpl);
        //路径配置信息
        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setTablePrefix("t_"); // 表名前缀
        strategy.setChainModel(true);
        strategy.setEntityLombokModel(true); //使用lombok
        if (CollectionUtils.isEmpty(paramModel.tableNames)) {
            throw new RuntimeException("需要生成的数据库表为空");
        }
        strategy.setInclude(paramModel.tableNames.toArray(new String[paramModel.tableNames.size()]));  // 逆向工程使用的表   如果要生成多个,这里可以传入String[],可变参数
        strategy.setRestControllerStyle(true);
        strategy.setEntitySerialVersionUID(false);
        strategy.setEntityColumnConstant(true);
        strategy.setVersionFieldName(paramModel.versionColumn);
        strategy.setLogicDeleteFieldName(paramModel.deleteColumn);
        strategy.setTableFillList(
                Arrays.asList(new TableFill(paramModel.insertColumn, FieldFill.INSERT), new TableFill(paramModel.updateColumn, FieldFill.UPDATE))
        );
        mpg.setStrategy(strategy);


//        //5、声明自定义Velocity键值对
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("parent", pc.getParent());
                map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                map.put("manager", pc.getParent() + StringPool.DOT + paramModel.packageManager);
                map.put("managerImpl", pc.getParent() + StringPool.DOT + paramModel.packageManagerImpl);
                map.put("paramPath", pc.getParent() + StringPool.DOT + paramModel.packageParam);
                map.put("voPath", pc.getParent() + StringPool.DOT + paramModel.packageVo);
                if (!CollectionUtils.isEmpty(paramModel.controllerNormalObjList)) {
                    map.put("controllerClazz", paramModel.controllerNormalObjList);
                }
                if (!CollectionUtils.isEmpty(paramModel.managerNormalObjList)) {
                    map.put("managerClazz", paramModel.managerNormalObjList);
                }
                this.setMap(map);
            }
        };

        //6. 配置自定义生成文件
        List<FileOutConfig> focList = new ArrayList<>();
        List<String> templateList = getTemplateList();
        for (String template : templateList) {
            collectionFileOutConfig(template, focList, pc, paramModel);
        }
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //7. 配置controller、service、serviceImpl、mapper自定义模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("/templates/controller.java");
        templateConfig.setService("/templates/service.java");
        templateConfig.setServiceImpl("/templates/serviceImpl.java");
        templateConfig.setEntity("/templates/entity.java");
        mpg.setTemplate(templateConfig);

        //8. 执行
        mpg.execute();

    }

    private static void collectionFileOutConfig(String template, List<FileOutConfig> focList, PackageConfig pc, GeneratorBo paramModel) {
        FileOutConfig fileOutConfig = new FileOutConfig(template) {
            @Override
            public String outputFile(TableInfo tableInfo) {

                String javaPath = "/src/main/java";
                String resourcePath = "/src/main/resources";
                String path = "";

                if ("/templates/mapper.xml.vm".equals(template)) {
                    path = resourcePath + "/" + paramModel.packageXml.replaceAll("\\.", "/") + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                } else if ("/templates/managerImpl.java.vm".equals(template)) {
                    path = javaPath + "/" + pc.getParent().replaceAll("\\.", "/") + "/" + paramModel.packageManagerImpl.replaceAll("\\.", "/") + "/" + tableInfo.getEntityName() + "ManagerImpl" + StringPool.DOT_JAVA;
                } else if ("/templates/manager.java.vm".equals(template)) {
                    path = javaPath + "/" + pc.getParent().replaceAll("\\.", "/") + "/" + paramModel.packageManager.replaceAll("\\.", "/") + "/" + tableInfo.getEntityName() + "Manager" + StringPool.DOT_JAVA;
                } else if ("/templates/addParam.java.vm".equals(template)) {
                    path = javaPath + "/" + pc.getParent().replaceAll("\\.", "/") + "/" + paramModel.packageParam.replaceAll("\\.", "/") + "/" + tableInfo.getEntityName() + "AddParam" + StringPool.DOT_JAVA;
                } else if ("/templates/updateParam.java.vm".equals(template)) {
                    path = javaPath + "/" + pc.getParent().replaceAll("\\.", "/") + "/" + paramModel.packageParam.replaceAll("\\.", "/") + "/" + tableInfo.getEntityName() + "UpdateParam" + StringPool.DOT_JAVA;
                } else if ("/templates/voEntity.java.vm".equals(template)) {
                    path = javaPath + "/" + pc.getParent().replaceAll("\\.", "/") + "/" + paramModel.packageVo.replaceAll("\\.", "/") + "/" + tableInfo.getEntityName() + "Vo" + StringPool.DOT_JAVA;
                }

                return System.getProperty("user.dir") + path;
            }
        };
        focList.add(fileOutConfig);
    }

    private static List<String> getTemplateList() {
        List<String> templateList = new ArrayList<>();
        String mapperTemplatePath = "/templates/mapper.xml.vm";
        String managerTemplatePath = "/templates/manager.java.vm";
        String extManagerTemplatePath = "/templates/managerImpl.java.vm";
        String addParamTemplatePath = "/templates/addParam.java.vm";
        String updateParamTemplatePath = "/templates/updateParam.java.vm";
        String voEntityTemplatePath = "/templates/voEntity.java.vm";

        templateList.add(mapperTemplatePath);
        templateList.add(managerTemplatePath);
        templateList.add(extManagerTemplatePath);
        templateList.add(addParamTemplatePath);
        templateList.add(updateParamTemplatePath);
        templateList.add(voEntityTemplatePath);
        return templateList;
    }
}
