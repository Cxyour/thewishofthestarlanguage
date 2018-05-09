package com.example.lenovo.thewishofthestarlanguage.contact;

import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureBean;
import com.example.lenovo.thewishofthestarlanguage.model.entity.TreaSureLunBoTuBean;

/**
 * Created by 陈伟霆 on 2018/5/7.
 */

public interface ITreasureContact {
    interface view {
        void showTreSure(TreaSureBean treaSure);

        void showLunbotu(TreaSureLunBoTuBean treaSureLunBoTu);
    }

    interface presenter {
        void loadTreSure(int index);

        void loadLunbotu();
    }
}
