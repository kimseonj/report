package com.study.java.day1.domain.store;

import com.study.java.day1.Utils;

public class JunkShop extends Store implements BuyAble {

    public JunkShop(Product[] products) {
        super("고물상", products);
    }

    @Override
    public void action() {
        buy();
    }

    @Override
    public void buy() {
        int chooseProductNumber = 0;
        while (true) {
            chooseProductNumber = Utils.validationNumber();

            if (chooseProductNumber <= products.length && chooseProductNumber > 0) {
                break;
            } else {
                System.out.print("선택지에서 골라주세요! : ");
            }
        }
        Product chooseProduct = products[chooseProductNumber - 1];

        // 판매 할 갯수 선택 및 재고 증가
        System.out.print("구매 할 갯수를 눌러주세요. : ");
        int quantity = 0;
        while (true) {
            quantity = Utils.validationNumber();

            if (quantity <= chooseProduct.getQuantity() && quantity > 0) {
                break;
            } else {
                System.out.print("재고가 부족합니다... " + chooseProduct.getName() + "의 재고는 " + chooseProduct.getQuantity() + "개 있습니다. 수량 안에서 선택해주세요. : ");
            }
        }
        chooseProduct.increaseQuantity(quantity);

        System.out.println("\n" + chooseProduct.getName() + "을(를) " + quantity + "개 판매 하셨습니다.");
        System.out.println("판매금액은 " + chooseProduct.getPrice() * quantity + "원 입니다. 입구에서 받아가세요.");
    }
}
