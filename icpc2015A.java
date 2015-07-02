package icpc2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class icpc2015A {
	public static void main(String[] args) {
		try {
			// 読み込みファイルの設定
			File fileIn = new File("./src/icpc2015/A.txt");// プロジェクトフォルダからの相対パス
			BufferedReader br = new BufferedReader(new FileReader(fileIn));

			// 出力(書き込み)ファイルの設定
			File fileOut = new File("./src/icpc2015/A_ans.txt");
			PrintWriter pw = new PrintWriter(fileOut);

			String str;
			while ((str = br.readLine()) != null) {
				String[] strAry = str.split("\\s"); // 空白で分割
				int n = Integer.parseInt(strAry[0]);  //受験者
				int nmin = Integer.parseInt(strAry[1]);; //合格人数最小
				int nmax = Integer.parseInt(strAry[2]);; //合格人数最大
				
				if(n ==0){
					break;
				}
				
				int[] score = new int[n];//それぞれの得点を入れる配列
				int gap = 0 ; //最高ギャップ
				int ans = 0; //回答(最高ギャップ時の合格人数)
				
				for(int i =0; i<n;i++){
					str = br.readLine();
					score[i] = Integer.parseInt(str);
				}
				for(int i = nmin ;i<=nmax;i++){
					int g =score[i-1] - score[i];
					
				System.out.println(g);
					if(gap <= g){
						gap = g;
						ans = i;
					}
				}
				
				pw.println(ans);
			}
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
