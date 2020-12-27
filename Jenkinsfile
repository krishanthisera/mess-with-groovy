node{
    stage("SCM"){
        echo 'Source Code checkout'
        git branch: '${branch}', url: 'https://github.com/krishanthisera/mess-with-groovy.git'
    }
    stage("Build")
        try{
            echo "Building.. 'sup nerd"
            // sh 'dotnet --version'
            echo "Almost there buddy"
            @Library('releasenotes')
        }
        catch(ex){
            echo "There is an issue pal"
            echo ex.toString();
            currentBuild.result = 'FAILURE'
        }
        finally{
            echo "Time for a beer"
        }
    stage("Testing"){
        echo "Testing..."
    }
    stage("Deploy"){
        echo "Deploying..."
        echo "Smoking kills"
    }
}