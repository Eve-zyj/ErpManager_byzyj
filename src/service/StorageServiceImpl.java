package service;

import dao.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Storage;
import tools.PageUtils;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public int addStorage(Storage storage) {
        return storageMapper.addStorage(storage);
    }

    @Override
    public int getCount() {
        return storageMapper.getCount();
    }

    @Override
    public List<Storage> getStorages(PageUtils pageUtils) {
        return storageMapper.getStorages(pageUtils);
    }

    @Override
    public int existName(String commodityName) {
        return storageMapper.existName(commodityName);
    }
}
