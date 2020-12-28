import java.io.*;
import groovy.io.*;
import hudson.model.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@NonCPS
def call(Map config=[:]){

    def dir = new File(pwd());
    // Jenkins console out the date
    def date = new Date();
    def sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    echo "The date is: " + sdf.format(date)
    // Jenkins console out the build number
    echo "The build number is: " + '${BUILD_NUMBER}'
    //SCM Change logs
    def changeLogSets = currentBuild.changeSets;

    new File(dir.path + "/releasenote.md").withWriter('utf-8')
    {
        writer ->
        // dir.eachFileRecurse(FileType.ANY){
        //     file ->
        //     if (file.isDirectory()){
        //         writer.writeLine("(d)" + file.name);
        //     }
        //     else
        //         writer.writeLine("\t" + "(f)" + file.name + "--->" + file.length());
        // }
        if(config.change != "false"){
            for ( change in changeLogSets){
                def entries = change.items;
                for (entry in entries){
                    writer.writeLine("${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}")
                    for (file in entry.affectedFiles){
                        writer.writeLine("\t ${file.editType.name} ${file.path}");
                    }
                }
            }
        }
    }
}