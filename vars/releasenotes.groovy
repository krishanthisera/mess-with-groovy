import java.io.*;
import groovy.io.*;



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
}