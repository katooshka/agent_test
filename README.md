# agent_test

This app is written in Java. It allows to process AgentTest data and output required results. 
The app requires the path to the data file and brand factor value as arguments.
Data file should be presented in CSV format and should not include commas as double values delimiters. 
After being calculated the required values are printed to STDOUT. If errors occur during the processing they are printed to STDERR.

## Install

    sudo add-apt-repository ppa:webupd8team/java -y

    sudo apt-get update

    sudo apt-get install oracle-java8-installer

    sudo apt-get install oracle-java8-set-default
    
    sudo apt-get install maven
    
    sudo apt-get install git
    
    git clone https://github.com/katooshka/hacker_news_scraper/
    
    cd hacker_news_scraper
    
    mvn clean
    
    mvn package
    
    ./agent --process <file_path> <brand_factor>

## Used external libraries

JUnit Mockito

## Comments on the code structure

I came up with two approaches to the processing of CSV file. The first is just to read the file line by line, parse and process it and update the resulting values immediately without creating extra List of Java objects. The second approach is to read the file line by line, parse each line into a specially created Java object, put this object into the list and then process the list. I have chosen the second one, as I think it this allows the code to be more structured. However, the first approach could be preferred if the number of entries of the input file was too large so that maintaining and processing a list of millions of Java object were too consuming.
