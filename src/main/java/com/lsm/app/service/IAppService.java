package com.lsm.app.service;

import com.lsm.app.dto.AppDTO;
import entity.app.AppEntity;

public interface IAppService {
    String test();

    void testElegantShutdown();

    AppEntity getApp();

    Integer saveApp(AppDTO appDTO);
}
