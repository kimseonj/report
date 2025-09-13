package com.study.java.day1.domain.store;

public class OliveYoungBranch extends OliveYoung {
    int eventRate;

    public OliveYoungBranch(String storeName, Product[] products, int branchNumber, int eventRate) {
        super("올리브영 " + storeName, products, branchNumber);
        this.eventRate = eventRate;
    }

    @Override
    public void enterStore() {
        if (eventRate > 0) {
            System.out.println("안녕하세요. " + name + " 입니다.\n");
            System.out.println("저희 매장은 현재 " + eventRate + "% 할인 행사중입니다.\n");
        } else {
            super.enterStore();
        }
    }

    /**
     * 행사 퍼센트에 따른 sell() 메서드 동작 조건문
     *
     * 지점마다 다른 할인행사를 진행하고 있습니다.
     * 할인이 있다면 본사의 할인 판매방식, 할인이 없다면 본사의 일반 판매방식을 진행합니다.
     */
    @Override
    public void action() {
        if (eventRate > 0) {
            super.sell(eventRate);
        } else {
            super.sell();
        }
    }
}
