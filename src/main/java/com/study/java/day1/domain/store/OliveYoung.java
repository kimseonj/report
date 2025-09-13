package com.study.java.day1.domain.store;

import com.study.java.day1.Utils;

public class OliveYoung extends Store implements SellAble{
    int branchNumber;

    public OliveYoung(Product[] products) {
        super("올리브영 본사", products);
    }

    public OliveYoung(String name, Product[] products, int branchNumber) {
        super(name, products);
        this.branchNumber = branchNumber;
    }

    @Override
    public void action() {
        System.out.println("본사는 상품을 판매하지 않습니다.");
    }

    @Override
    public void sell() {
        // 판매할 상품 고르기
        System.out.print("어떤 상품을 구매하시겠어요? : ");
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

        // 갯수 선택
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

        System.out.println("\n" + chooseProduct.getName() + "을 " + quantity + "개 구매 합니다.");
        System.out.println("가격은 " + chooseProduct.getPrice() * quantity + "원 입니다." );
    }

    public void sell(int eventRate) {
        // 판매할 상품 고르기
        System.out.print("어떤 상품을 구매하시겠어요? : ");
        int chooseProductNumber = 0;
        while (true) {
            chooseProductNumber = Utils.validationNumber();

            if (chooseProductNumber <= products.length && chooseProductNumber > 0) {
                break;
            } else {
                System.out.print("선택지에서 골라주세요. : ");
            }
        }
        Product chooseProduct = products[chooseProductNumber - 1];

        // 갯수 선택
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

        System.out.println("\n" + chooseProduct.getName() + "을 " + quantity + "개 구매 합니다.");
        System.out.println("할인 행사 중입니다!! 전체 상품 " + eventRate + "% 할인되었습니다.");
        System.out.println("할인 된 가격은 " + (chooseProduct.getPrice() * quantity * (100-eventRate) / 100) + "원 입니다." );
    }
}
