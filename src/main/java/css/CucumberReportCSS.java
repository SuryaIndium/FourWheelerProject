package css;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class CucumberReportCSS {
	public static void main(String[] args) {

		CompletableFuture.runAsync(() -> {
			try {

				FileReader reader = new FileReader("css.properties");
				Properties prop = new Properties();
				prop.load(reader);

				String outputDitrectory = prop.getProperty("outputDitrectory");

				for (int i = 0; i < 100; i++) {

					String css = "";

					try {

						File myObj = new File(outputDitrectory + "/cucumber-html-reports/css/cucumber.css");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							css += myReader.nextLine() + "\n";
						}
						myReader.close();

						css += "\nimg {\r\n" + "    max-width: " + prop.getProperty("width") + "%;\r\n"
								+ "    max-height: " + prop.getProperty("height") + "%;\r\n" + "}\r\n";

						css += "\n#navigation p:before {\r\n"
								+ "    background-image: url(\"../logo/Customer_Logo.png\");\r\n"
								+ "    background-size: 150px 50px;\r\n" + "    display: inline-block;\r\n"
								+ "    width: 150px; \r\n" + "    height: 50px;\r\n" + "    content:\"\";\r\n"
								+ "    vertical-align: middle;\r\n" + "}\r\n" + "\r\n" + "#navigation ul:after {\r\n"
								+ "\r\n" + "    background-image: url(\"../logo/Indium_Software_Logo.png\");\r\n"
								+ "    background-size: 145px 50px;\r\n" + "    display: inline-block;\r\n"
								+ "    width: 145px; \r\n" + "    height: 50px;\r\n" + "    content:\"\";\r\n"
								+ "    vertical-align: middle;\r\n" + "}\r\n" + "\r\n" + "#navigation p:after {\r\n"
								+ "    content:\" - Mobile Test Automation Report\";\r\n" + "}\r\n" + "\r\n"
								+ ".navbar-text {\r\n" + "    margin-top: 0px;\r\n" + "    margin-bottom: 0px;\r\n"
								+ "}\r\n" + "\r\n" + "#navigation p{\r\n" + "    font-weight: bold;\r\n"
								+ "    padding-left: 5%;\r\n" + "    font-size: 18px;\r\n" + "    color: darkblue;\r\n"
								+ "    width: 55%;\r\n" + "    text-align: left;\r\n" + "}\r\n" + "\r\n"
								+ "#navigation {\r\n"
								+ "    background-image: linear-gradient(10deg, lightblue, #c5fceb);\r\n" + "}\r\n"
								+ "\r\n" + "#navigation ul{\r\n" + "    margin-right: 7%;\r\n" + "}\r\n" + "\r\n"
								+ "#navigation ul a:hover{\r\n" + "    font-weight: bold;\r\n"
								+ "    color: darkblue;\r\n" + "}\r\n" + "\r\n"
								+ ".navbar-default .navbar-nav>.active>a, .navbar-default .navbar-nav>.active>a:focus, .navbar-default .navbar-nav>.active>a:hover {\r\n"
								+ "    font-weight: bold;\r\n" + "    font-size: 15px;\r\n"
								+ "    background-color: transparent;\r\n" + "    color: darkblue;\r\n"
								+ "    border-bottom: 2px solid darkblue;\r\n" + "}\r\n" + "\r\n"
								+ ".container-fluid {\r\n" + "    margin-top: 5px;\r\n" + "}\r\n" + "\nbody {\r\n"
								+ "    background-image: linear-gradient(180deg, white, #c5fceb);\r\n" + "}\r\n"
								+ "\r\n" + ".navbar-default {\r\n" + "    background-color: transparent;\r\n"
								+ "    border-color: transparent;\r\n" + "}";

						FileWriter myWriter = new FileWriter(
								outputDitrectory + "/cucumber-html-reports/css/cucumber.css");
						myWriter.write(css);
						myWriter.close();

						System.out.println("Cucumber Report - CSS updated");

						transferLogo(outputDitrectory);

						break;

					} catch (Exception e) {
					} finally {
						Thread.sleep(100);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void transferLogo(String outputDitrectory) throws InterruptedException {
		try {

			new File(outputDitrectory + "/cucumber-html-reports/logo/").mkdir();
			final File sourcecompanyLogo = new File("./logo/Customer_Logo.png");
			final File sourceclientLogo = new File("./logo/Indium_Software_Logo.png");

			final File destinationcompanyLogo = new File(
					outputDitrectory + "/cucumber-html-reports/logo/Customer_Logo.png");
			final File destinationclientLogo = new File(
					outputDitrectory + "/cucumber-html-reports/logo/Indium_Software_Logo.png");

			final InputStream in = new FileInputStream(sourcecompanyLogo);
			final OutputStream out = new FileOutputStream(destinationcompanyLogo);
			final byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();

			final InputStream in2 = new FileInputStream(sourceclientLogo);
			final OutputStream out2 = new FileOutputStream(destinationclientLogo);
			final byte[] buf2 = new byte[1024];
			int len2;
			while ((len2 = in2.read(buf2)) > 0) {
				out2.write(buf2, 0, len2);
			}
			in2.close();
			out2.close();

			for (int i = 0; i < 50; i++) {
				try {
					final File sourcefavicon = new File("./logo/favicon.png");
					final File destinationfavicon = new File(
							outputDitrectory + "/cucumber-html-reports/images/favicon.png");
					final InputStream in3 = new FileInputStream(sourcefavicon);
					final OutputStream out3 = new FileOutputStream(destinationfavicon);
					final byte[] buf3 = new byte[1024];
					int len3;
					while ((len3 = in3.read(buf3)) > 0) {
						out3.write(buf3, 0, len3);
					}
					in3.close();
					out3.close();
					break;
				} catch (Exception e) {
				} finally {
					Thread.sleep(100);
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(String.valueOf(ex.getMessage()) + " in  the specified directory.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
