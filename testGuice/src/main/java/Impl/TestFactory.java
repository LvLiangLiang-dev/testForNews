package Impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */

public interface TestFactory {
    TempSingal1 create(String name);
}
