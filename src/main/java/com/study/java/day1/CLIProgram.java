package com.study.java.day1;

import com.study.java.day1.domain.store.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * CLI 프로그램 제작
 *
 * 사용자는 가게를 선택할 수 있습니다.
 * 가게는 판매만, 구입만, 판매 구입 모두 가능한 가게가 존재합니다.
 *
 * CLI 애플리케이션에서는 BGM이 나옵니다. 키거나 끄고싶다면 언제 어느 상황일때나 ON, OFF를 해주세요.
 */
public class CLIProgram {
    static List<Store> stores = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("---------------------------------");
        System.out.println("어느때나 배경음악을 키고 싶으면 ON, 끄고 싶다면 OFF를 입력하세요.");

        // 가게 초기화
        initStore();

        // 가게 선택
        System.out.println("---------------------------------");
        for (int i = 1; i <= stores.size(); i++) {
            System.out.println(i + ". " + stores.get(i-1).getName());
        }
        Store selectStore = getStore();

        // 가게에서 할 행동
        System.out.println("---------------------------------");
        // 가게 들어가기
        selectStore.enterStore();
        // 상품 보여주기
        selectStore.showProducts();
        // 가게에 따른 행동 수행(판매, 구매)
        selectStore.action();

        // 프로그램 종료
        System.out.print("---------------------------------");
    }

    /**
     * 가게 데이터 초기화
     */
    static void initStore() {
        Product[] oliveYoungProducts = new Product[]{
                new Product("스킨", 10000, 20),
                new Product("로션", 8000, 2),
                new Product("수분크림", 15000, 20)};
        Store oliveYoungGangnam = new OliveYoungBranch("강남점", oliveYoungProducts, 100, 0);
        Store oliveYoungPanyo = new OliveYoungBranch("판교점", oliveYoungProducts, 200, 10);

        Store jewelryShop = new JewelryShop(new Product[]{
                new Product("반지", 300000, 20),
                new Product("목걸이", 800000, 49),
                new Product("귀걸이", 150000, 30)});

        Store junkShop = new JunkShop(new Product[]{
                new Product("폐지", 1000, 10),
                new Product("공병", 500, 40),
                new Product("고철", 8000, 94)});

        stores.add(oliveYoungGangnam);
        stores.add(oliveYoungPanyo);
        stores.add(jewelryShop);
        stores.add(junkShop);
    }

    /**
     * 가게 선택 메서드
     * @return
     */
    private static Store getStore() {
        int select = 0;
        while (true) {
            System.out.print("이용하고 싶은 가게를 골라주세요. : ");
            select = Utils.validationNumber();

            if (select > stores.size() || select < 1) {
                System.out.println("선택지의 숫자를 입력해주세요.");
            } else {
                return stores.get(select - 1);
            }
        }
    }
}
