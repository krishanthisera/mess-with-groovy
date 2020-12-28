import java.io.*;
import groovy.io.*;
import java.text.SimpleDateFormat;

@NonCPS
def call(Map config=[:]){
    def dir = new File(pwd());
    new File(dir.path + "/releasenote.md").withWriter('utf-8')
    {
        writer ->
        dir.eachFileRecurse(FileType.ANY){
            file ->
            if (file.isDirectory()){
                writer.writeLine("(d)" + file.name);
            }
            else
                writer.writeLine("\t" + "(f)" + file.name + "--->" + file.length());
        }
    }
    def date = new Date();
    def sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    echo "The date is: " + sdf.format(date)
}