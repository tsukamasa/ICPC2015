package icpc2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class icpc2015B {
	public static void main(String[] args) {
		try {
			// 読み込みファイルの設定
			File fileIn = new File("./src/icpc2015/B.txt");// プロジェクトフォルダからの相対パス
			BufferedReader br = new BufferedReader(new FileReader(fileIn));

			// 出力(書き込み)ファイルの設定
			File fileOut = new File("./src/icpc2015/B_ans.txt");
			PrintWriter pw = new PrintWriter(fileOut);

			String str;
			while ((str = br.readLine()) != null) {
				// String[] strAry = str.split("\\s"); // 空白で分割
				int n = Integer.parseInt(str); // 単語数
				boolean[] checks = new boolean[5]; // デフォでfalse

				String[] strAry = new String[n];
				if (n == 0) {
					break;
				}

				for (int i = 0; i < n; i++) {
					strAry[i] = br.readLine();
				}

				int check = 0;
				int ans = 0;
				int cont = 0;// つづきから

				boolean flag = true;
				int count =0;//カウント
				
				while(flag) {
					
					// 最初の5文字判定
					if (!checks[0]) {
						check = 0;
						cont = 0;
						
						for (int i = count; i < n; i++) {
							check += strAry[i].length();
							if (check == 5) {
								checks[0] = true;
								ans = count+1;
								cont = i;
								break;
							}
							if (check > 5) {
								reset(checks);
								break;

							}
						}
						
					}
					// 次の7文字判定
					if (!checks[1] && checks[0]) {
						check = 0;
						for (int i = cont+1; i < n; i++) {
							check += strAry[i].length();
							if (check == 7) {
								checks[1] = true;
								cont = i;
								break;
							}
							if (check > 7) {
								reset(checks);
								break;

							}
						}
					}
					// 次の5文字判定
					if (!checks[2] && checks[1]) {
						check = 0;
						for (int i = cont+1; i < n; i++) {
							check += strAry[i].length();
							if (check == 5) {
								checks[2] = true;
								cont = i;
								break;
							}
							if (check > 5) {
								reset(checks);
								break;

							}
						}
					}

					// 次の7文字判定
					if (!checks[3] && checks[2]) {
						check = 0;
						for (int i = cont+1; i < n; i++) {
							check += strAry[i].length();
							if (check == 7) {
								checks[3] = true;
								cont = i;
								break;
							}
							if (check > 7) {
								reset(checks);
								break;

							}
						}
					}

					// 次の7文字判定
					if (!checks[4] && checks[3]) {
						check = 0;
						for (int i = cont+1; i < n; i++) {
							check += strAry[i].length();
							if (check == 7) {
								checks[4] = true;
								cont = i;
								break;
							}
							if (check > 7) {
								reset(checks);
								break;

							}
						}
					}

					for (int i = 0; i < checks.length; i++) {
						if (!checks[i]) {
							flag = true;
							//break;
						}else{
						flag = false;

						}
					}
					
					count++;
					if(count ==n){
						flag = false;
						System.out.println("あふれた");
					}
				}//while(2つ目)
				
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

	public static void reset(boolean[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i] = false;
		}
	}
}
