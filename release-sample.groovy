import java.io.*;
import groovy.io.*;

def dir = new File("/Users/krishanthisera/OneDrive/Learning/groovy/101");

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