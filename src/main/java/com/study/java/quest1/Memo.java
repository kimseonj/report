package com.study.java.quest1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Memo {
    static ArrayList<String> memos = new ArrayList<>();
    static ArrayList<String> content = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        memos.add("애플");
        content.add("암호화->애플");

        String showMenu = "1. 작성 2. 조회 3. 수정 4. 삭제 5. 추가기능 6. 종료";

        int userSelect = 0;

        while (userSelect != 6) {
            System.out.println(showMenu);
            System.out.print("메뉴 선택 : ");

            userSelect = scanner.nextInt();
            switch (userSelect) {
                case 1 -> {
                    System.out.println("작성");
                    break;
                }
                case 2 -> {
                    showMemos();
                    break;
                }
                case 3 -> {
                    showMemos();
                    int updateIndex = getInput(scanner);

                    System.out.print("제목을 수정하세요. : ");
                    String updateTitle = scanner.nextLine();
                    editMemo(memos, updateIndex, updateTitle);

                    System.out.print("\n내용을 수정하세요. : ");
                    String updateContent = scanner.nextLine();
                    editMemo(content, updateIndex, updateContent);

                    break;
                }
                case 4 -> {
                    showMemos();
                    int deleteIndex = getInput(scanner);

                    memos.remove(deleteIndex);
                    content.remove(deleteIndex);
                    break;
                }
                case 5 -> {
                    System.out.println("추가기능");
                    break;
                }
                case 6 -> {
                    System.out.println("종료");
                    break;
                }
                default -> {
                    System.out.println("지원하지 않는 기능입니다.");
                }
            }
        }
    }

    public static void showMemos() {
        // 메모가 하나도 없다면 출력합니다.
        if (memos.isEmpty()) {
            System.out.println("저장된 메모가 없습니다.");
            return;
        }

        // 반복문을 이용해 memo를 전부 출력합니다.
        for (int i = 0; i < memos.size(); i++) {
            System.out.printf("제목 : %d. %s ", i+1, memos.get(i));
            System.out.println("\n내용 : " + content.get(i));
        }
    }

    public static void editMemo(ArrayList<String> list, int index, String updateString) {
        list.set(index, updateString);
    }

    public static int getInput(Scanner scanner) {
        System.out.print("메모를 선택하세요. : ");
        scanner.nextLine(); // 엔터가 버퍼에 남아있어서 제거 용도로 사용

        return scanner.nextInt() - 1;
    }
}
