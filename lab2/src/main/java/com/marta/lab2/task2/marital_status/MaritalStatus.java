package com.marta.lab2.task2.marital_status;

import lombok.Data;
import lombok.Getter;

@Getter
public enum MaritalStatus {
    SINGLE(1,"холост", "לִמצוֹץ"),
    MARRIED(2,"женат", "לְהִשתַנוֹת"),
    DIVORCED(5,"разведен", "לִנשוֹף"),
    WIDOW(3, "вдовец", "לְכַבֵּס");

    private final int dbCode;
    private final String russianDesc;
    private String denrewDesc;

    MaritalStatus(int dbCode, String russianDesc, String denrewDesc) {
        this.dbCode = dbCode;
        this.russianDesc = russianDesc;
        this.denrewDesc = denrewDesc;
    }

    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus[] statuses = values();
        for (MaritalStatus status : statuses) {
            if (status.dbCode == dbCode) {
                return status;
            }
        }
        throw new RuntimeException(dbCode + " not supported");
    }


    @Override
    public String toString() {
//        System.out.println(this.denrewDesc);
        return this.denrewDesc;
    }
}
