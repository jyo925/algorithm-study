package com.company.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//키 순 정렬된 신체검사 데이터 배열에서 특정한 사람의 키를 검색
//Comparator 사용
public class PhysExamSearch  {



    static class PhysData implements Comparable<PhysData>{

        private String name; //이름
        private int height; //키 
        private double vision; //시력

        public PhysData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhysData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }

        @Override
        public int compareTo(PhysData o) {
            return (this.height > o.height) ? 1 :
                    (this.height < o.height) ? -1 : 0;
        }

/*        //for 오름차순 정렬
        public static final Comparator<PhysData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysData> {
            @Override
            public int compare(PhysData o1, PhysData o2) {
                return (o1.height > o2.height) ? 1 :
                        (o1.height < o2.height) ? -1 : 0;
            }
        }*/
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        PhysData[] x = {
                new PhysData("이지윤", 162, 1.0),
                new PhysData("박지수", 168, 0.4),
                new PhysData("배로나", 150, 1.5),
                new PhysData("주석경", 182, 0.7),
        };

        System.out.println("찾을 사람의 키는?");

        int height = kb.nextInt();
//        int idx = Arrays.binarySearch(x, new PhysData("", height, 0.0), PhysData.HEIGHT_ORDER);
        PhysData member = new PhysData("", height, 0.0);

        int idx = Arrays.binarySearch(x, member);

        if (idx < 0) {
            System.out.println("없음");
        } else {
            System.out.println("찾은 데이터는 " + x[idx] + "입니다.");
        }
    }
    
}
