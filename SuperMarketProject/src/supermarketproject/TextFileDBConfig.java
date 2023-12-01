
package supermarketproject;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class TextFileDBConfig {
    
    public static void setHostAndPort(String host, String port){
        try{
            String pathDir = "C:\\Rjsofts\\";
           File f = new File(pathDir);
           f.mkdir();
           String pathFile = pathDir+"rjsofts-sales-management-db-config.txt";
            BufferedWriter filewriter = new BufferedWriter(new FileWriter(pathFile)); 
            filewriter.write("HOST=;"+host+";"+"\n"+"PORT=;"+port+";"+"\n");
            filewriter.flush();
            System.out.println("Finished");
        }catch(Exception ex){
            System.out.println(ex+"");
            System.out.println("Not Finished");
        }
    }
    
    public static String getHost(){
        String host = "";
        //ArrayList<String> list = new ArrayList<>();
        try{
            String path = "C:\\Rjsofts\\rjsofts-sales-management-db-config.txt";
            File f = new File(path);
            
            if(f.exists()){
                BufferedReader filereader = new BufferedReader(new FileReader(path));
                while(filereader.ready()){
                    String s = filereader.readLine().trim();
                    if(s.toUpperCase().startsWith("HOST")){
                        int i = 0;
                        for(String item : s.split(";")){
                            host = item;
                            if(i == 1)
                                return host;
                        }
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex+"");
        }
        return host;
    }
    
    public static String getPort(){
        String host = "";
        //ArrayList<String> list = new ArrayList<>();
        try{
            String path = "C:\\Rjsofts\\rjsofts-sales-management-db-config.txt";
            File f = new File(path);
            
            if(f.exists()){
                BufferedReader filereader = new BufferedReader(new FileReader(path));
                while(filereader.ready()){
                    String s = filereader.readLine().trim();
                    if(s.toUpperCase().startsWith("PORT")){
                        int i = 0;
                        for(String item : s.split(";")){
                            host = item;
                            if(i == 1)
                                return host;
                        }
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex+"");
        }
        return host;
    }
    
    public static void changePort(String port){
        String host = getHost();
        setHostAndPort(host, port);
    }
    
    public static void changeHost(String host){
        String port = getPort();
        setHostAndPort(host, port);
    }
    
    public static boolean isExistsFile(){
        File f = new File("C:\\Rjsofts\\rjsofts-sales-management-db-config.txt");
        if(f.exists()){
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }
    
}
