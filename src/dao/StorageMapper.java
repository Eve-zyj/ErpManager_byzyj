package dao;

import pojo.Storage;
import tools.PageUtils;

import java.util.List;

public interface StorageMapper {

    /**
     * 商品入库
     * @param storage 商品实体类
     * @return 受影响的行数
     */
    int addStorage(Storage storage);
    /**
     * 查询商品列表的数量
     */
    int getCount();

    /**
     * 获取所有商品信息，分页显示
     * @param pageUtils
     * @return
     */
    List<Storage> getStorages(PageUtils pageUtils);

    /**
     * 验证商品名称是否重复
     * @param commodityName 商品名称
     * @return 受影响的行数
     */
    int existName(String commodityName);
}
