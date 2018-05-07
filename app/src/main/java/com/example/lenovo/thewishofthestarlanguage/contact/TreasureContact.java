package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSure;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTu;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface TreasureContact  {
    interface view{
        void showTreSure(TreaSure treaSure);
        void showLunbotu(TreaSureLunBoTu treaSureLunBoTu);
    }
    interface  presenter{
        void loadTreSure();
        void loadLunbotu();
    }
}
