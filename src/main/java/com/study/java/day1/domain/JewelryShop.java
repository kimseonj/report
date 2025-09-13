package com.study.java.day1.domain;

import com.study.java.day1.Utils;

public class JewelryShop extends Store implements SellAble, BuyAble {
    public JewelryShop(Product[] products) {
        super("주얼리샵", products);
    }

    @Override
    public void action() {
        // 판매할지 구매할지 결정
        System.out.println("1. 물건을 '구매'할래요! \n2. 물건을 '판매'할래요!");
        System.out.print("번호를 입력해주세요 : ");

        int chooseAction;
        while (true) {
            chooseAction = Utils.validationNumber();

            if (chooseAction < 3 && chooseAction > 0) {
                break;
            } else {
                System.out.print("선택지에서 골라주세요! : ");
            }
        }

        if (chooseAction == 1) {
            sell();
        } else if (chooseAction == 2) {
            buy();
        }
    }

    @Override
    public void buy() {
        // 판매할 상품 고르기
        System.out.println("---------------------------------");
        System.out.print("판매 할 상품을 번호를 눌러주세요 : ");
        int chooseProductNumber = 0;
        while (true) {
            chooseProductNumber = Utils.validationNumber();

            if (chooseProductNumber < products.length + 1 && chooseProductNumber > 0) {
                break;
            } else {
                System.out.print("선택지에서 골라주세요! : ");
            }
        }
        Product chooseProduct = products[chooseProductNumber - 1];

        // 판매 할 갯수 선택 및 재고 증가
        System.out.print("판매 할 갯수를 눌러주세요. : ");
        int quantity = Utils.validationNumber();
        chooseProduct.increaseQuantity(quantity);

        System.out.println("\n" + chooseProduct.getName() + "을(를) " + quantity + "개 판매 하셨습니다.");
        System.out.println("판매금액은 " + chooseProduct.getPrice() * quantity + "원 입니다. 입구에서 받아가세요.");
    }

    @Override
    public void sell() {
        System.out.println("---------------------------------");
        System.out.print("구매하실 상품의 번호를 눌러주세요. : ");
        int chooseProductNumber = 0;
        while (true) {
            chooseProductNumber = Utils.validationNumber();

            if (chooseProductNumber < products.length + 1 && chooseProductNumber > 0) {
                break;
            } else {
                System.out.print("선택지에서 골라주세요! : ");
            }
        }
        Product chooseProduct = products[chooseProductNumber - 1];

        // 구매 할 갯수 선택 및 재고 감소
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

        chooseProduct.decreaseQuantity(quantity);

        System.out.println("\n" + chooseProduct.getName() + "을(를) " + quantity + "개 구매 합니다.");
        System.out.println("가격은 " + chooseProduct.getPrice() * quantity + "원 입니다.");
    }
}
