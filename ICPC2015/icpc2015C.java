package icpc2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class icpc2015C {
	public static void main(String[] args) {
		try {
			// 読み込みファイルの設定
			File fileIn = new File("./src/icpc2015/Input.txt");// プロジェクトフォルダからの相対パス
			BufferedReader br = new BufferedReader(new FileReader(fileIn));

			// 出力(書き込み)ファイルの設定
			File fileOut = new File("./src/icpc2015/Output.txt");
			PrintWriter pw = new PrintWriter(fileOut);

			
			//1行目をとる
			String str;
			while ((str = br.readLine()) != null) {
				int n = Integer.parseInt(str); // 行数

				int ans = 0;

				int[] x = new int[n];// 数値
				for (int i = 0; i < x.length; i++) {
					x[i] = -1;
				}
				int[] y = new int[n];// xにおけるレベル(.の数)

				String[] z = new String[n];// 記号

				if (n == 0) {
					break;
				}

				//とった1行目の数字(行)分回す
				for (int i = 0; i < n; i++) {
					str = br.readLine();
					if (str.length() == 1) {
						if (Character.isDigit((str.charAt(0)))) {
							x[i] = Integer.parseInt(str);
						} else {

							z[i] = str;
						}
						y[i] = 0;
					} else {
						String[] strAry = str.split("");
						int w = 0;// レベルの数
						for (int j = 0; j < strAry.length; j++) {

							if (strAry[j].equals(".")) {
								w++;
							} else {
								if (Character.isDigit((str.charAt(0)))) {
									x[i] = Integer
											.parseInt(strAry[str.length() - 1]);
								} else {
									z[i] = strAry[(str.length() - 1)];
								}
								y[i] = w;
							}
						}
					}

					//
					// 表示のとこ
					if (x[i] != -1) {
						// System.out.println(x[i] + ":レベル" + y[i]);
					} else {
						// System.out.println(z[i] + ":レベル" + y[i]);
					}
				}
				if(n == 1){
					ans = x[0];
				}else{

				for (int i = 0; i < n; i++) {
					// 演算子だったら
					try {
						if (!z[i].equals(null)) {
							for (int j = i; j < n; j++) {
								if (y[j] == y[i] + 1) {
									if (z[i].equals("+")) {
										ans += Integer.parseInt(z[j]);
									} else if (z[i].equals("*")) {
										ans *= Integer.parseInt(z[j]);
									}
								}
							}
						}
					} catch (NullPointerException e) {

					}
				}
				}
					System.out.println(ans);
				

				System.out.println("");

				// pw.println();
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
