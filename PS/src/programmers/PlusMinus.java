package programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class PlusMinus {
    public static void main(String arr[]) {
        Scanner sc = new Scanner(System.in);

        int index = 0;
        int answer = 0;
        int temp = 0;
        int num = sc.nextInt();

        //리스트 생성
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i<num; i++){
            arrayList.add(sc.next());
        }
        //+찾기
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.contains("+")){
                index = arrayList.indexOf("+");
                temp = Integer.parseInt(arrayList.get(index-1))+Integer.parseInt(arrayList.get(index+1));
                arrayList.set(index-1,String.valueOf(temp));
                arrayList.remove(index);
                arrayList.remove(index);
            }
        }
        if (arrayList.contains("-")){
            answer = Integer.parseInt(arrayList.get(arrayList.size()-1));
            int i = arrayList.size()-3;
            while (i > -1) {
                answer = Integer.parseInt(arrayList.get(i)) - answer;
                i = i-2;
            }
        }
        System.out.println(answer);
    }
}
