package com.tnpy.common.Enum;

/**
 * @Description: TODO
 * @Author: LLS
 * @Date: 2018/12/19 14:41
 */
public class StatusEnum {
    public static  enum ResponseStatus {
        Success("成功", 1), Fail("失败", 2);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private ResponseStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (ResponseStatus c : ResponseStatus.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static  enum InOutStatus {
        Input("入库", 1), Output("出库", 2);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private InOutStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (ResponseStatus c : ResponseStatus.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static  enum StatusFlag {
        abandon("弃用", -1), using("使用中", 1);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private StatusFlag(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (StatusFlag c : StatusFlag.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }
    public static  enum WorkOrderStatus {

        ordered("已下单", 1), printed("已打印", 2), doing("'已开工'", 3), finished("'已完成'", 4), closed("已关闭",5), deleted("已删除", 6), repairin("维修入库",7);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private WorkOrderStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (ResponseStatus c : ResponseStatus.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }
}
