import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.home") + File.separator + "test.txt");
        File fileCopy = new File(System.getProperty("user.home") + File.separator + "testCopy.txt");
        createFile(file, fileCopy);
    }

    static void createFile(File file, File fileCopy) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(file));//Считываем информацию из файла
        byte[] buffer = new byte[1024];//объявляем размер буфера
        String str = "";//объявляем пустую строку
        while (in.read(buffer) != -1) {
            str = str.concat(new String(buffer)).concat("\n");//присваиваем переменной данные из файла
        }
        System.out.println(str);
        in.close();//закрыли файл
        str = str.trim();//очищаем текст от лишних нулей(пробелов)
        str=str.replace('a', '1');
        System.out.println(str);

        OutputStream out = new FileOutputStream(fileCopy, true);
        out.write(str.getBytes());
    }
}
