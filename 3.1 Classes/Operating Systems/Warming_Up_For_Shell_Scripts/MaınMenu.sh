#!/bin/bash

# useful commands:
# $# will give the number of input arguments passed.
# 2>/dev/null will ignore errors when using built-in commands.

function check_palindrome() 
{
    local input=$1; # get input and store into the local variable.
    local input_clean=${input//[^a-zA-Z]/}
    local number_of_chars=${#input}; # calculate total number of characters within the given input.
    local input_rev
     input_clean=${input_clean}
    for ((i=$number_of_chars-1; i>=0; i--))
    do
        input_rev="$input_rev${input_clean:$i:1}"
    done
    input_rev=${input_rev}
    if [ "$input_clean" = "$input_rev" ]; then
        echo "The input $input IS A palindrome."
        else
        echo "The input $input IS NOT A palindrome."
    fi

}


function move_c_files_with_given_path()
{
local path_arg=$1
path=$PWD
if [ $# -lt 1 ]
then
echo "Invalid Path!!"
echo
exit 3
elif [ ! -d $path_arg ] && [ ! -z $path_arg ]
then
echo "Invalid Path!!"
elif [ -z $path_arg   ] && [ -d "$path/cprogs" ]  #If the path is zero and the directory already exists
then
echo "A directory named cprogs is already exists under the current working directory."
mv *.c "$PWD/cprogs/" 2>/dev/null
echo "content of $PWD/cprogs : "
ls $PWD/cprogs
elif [ -s $path_arg ] && [ -d "$path_arg/cprogs" ]  #If the path is exists and directory exists
then
echo "A directory named cprogs is already exists under the current path"
mv *.c "$path_arg/cprogs/" 2>/dev/null
echo "content of $path_arg/cprogs : "
ls $path_arg/cprogs
elif [ ! -z $path_arg ] && [ ! -d "$path_arg/cprogs" ] #If the path is exists and directory not exists
then
mkdir "$path_arg/cprogs/"
mv *.c "$path_arg/cprogs/" 2>/dev/null
echo "A directory named cprogs is created under the path and the files are moved."
echo "content of $path_arg/cprogs : "
ls $path_arg/cprogs
elif [ -z $path_arg  ] && [ ! -d "$path/cprogs" ] #If the path is zero and the directory also not exists
then
mkdir cprogs
mv *.c "$PWD/cprogs/" 2>/dev/null
echo "A directory named cprogs is created under the current working directory and the files are moved."
echo "content of $PWD/cprogs : "
ls $PWD/cprogs
echo
fi
}

function draw_hollow_square()
{
num1=$1
num2=$2
num1=$num1
num2=$num2
dif=0
dif=$(( num1 - num2 ))
divided=$(( dif / 2 ))

echo "num1 = "$num1" num2 = "$num2" dif = "$dif" "
echo "Hello this is square drawing programme"
#######First Part##########
for (( i = 1; i <= $divided; i++ ))
do
for (( j = 1; j <= $num1; j++ ))
do echo -n "*"
done
echo ""
done
#########Second Part##################
for (( i = 1; i <= $num2; i++ ))
do
for (( j = 1; j <= $divided; j++ ))
do echo -n "*"
done
for(( j = 1; j <= $num2; j++ ))
do echo -n " "
done
for (( j = 1; j <= $divided; j++ ))
do echo -n "*"
done
echo ""
done
#########Third Part##################
for (( i = 1; i <= $divided; i++ ))
do
for (( j = 1; j <= $num1; j++ ))
do echo -n "*"
done
echo ""
done
}
#########END OF FUNCTION###############
function uppercase_Converter_Inside_A_File()
{
local wildcard=$1
local path_arg=$2
if [ ! -d $path_arg ] && [ ! -z $path_arg ]
then
echo "invalid path"

elif [ -z $path_arg ]
then
yourfilenames=`ls ./*.txt`
for eachfile in $yourfilenames
do
  awk '{gsub(/'$wildcard'/,"LALA")}1' $eachfile > temp.txt && mv temp.txt $eachfile
done
fi
}

function delete_empty_files()
{
   # store arguments in local variables
   local arg1=$1
   local arg2=$2

   # there are two inputs, one is path arg. and the other one is the option.
   if [ ! -z "$arg1" ] && [ ! -z "$arg2" ]; then
      local find_result1=$(find $arg1 -type f -size 0) # store find result in a variable.
      # loop over the find result and ask user whether delete the file or not.
      for file in $find_result1
      do
         # display a small message for the user, using "basename" command to show only the file name, not the full path.
         read -p "Do you want to delete $(basename $file)? [y/n] " delete
         if [ "$delete" == "y" ] || [ "$delete" == "Y" ]; then # the input can be both "y" and "Y".
            rm -f $(basename $file) # delete the file.
            echo "1 file is deleted."
         elif [ "$delete" == "n" ] || [ "$delete" == "N" ]; then # the input can be both "n" and "N".
            echo "Returning to the main screen..."
         else
            echo "Invalid choice!"
         fi
      done
   # there is only one input entered. It is either a path argument or an option ("-R").
   elif [ ! -z "$arg1" ] && [ -z "$arg2" ]; then
      # if -R option is enabled, find and store the "find" result then ask user to delete file or not. The procedures is same as above.
      if [ "$arg1" == "-R" ]; then
         local find_result2=$(find $PWD -type f -size 0)
         for file in $find_result2
         do
            read -p "Do you want to delete $(basename $file)? [y/n] " delete
            if [ "$delete" == "y" ] || [ "$delete" == "Y" ]; then
               rm -f $file
               echo "1 file is deleted."
            elif [ "$delete" == "n" ] || [ "$delete" == "N" ]; then
               echo "Returning to the main screen..."
            else
               echo "Invalid choice!"
            fi
         done
      # the input is a path argument. Then the option -R is not enabled so the functioun will not work recusively.
      elif [ -d $arg_1 ]; then
         # use -maxdepth option to force the non recursive find command.
         local find_result3=$(find $arg_1 -maxdepth 1 -type f -size 0)
         # loop through the find result and delete the files as user wish.
         for file in $find_result3
         do
            read -p "Do you want to delete $(basename $file)? [y/n] " delete
            if [ "$delete" == "y" ] || [ "$delete" == "Y" ]; then
               rm -f $file
               echo "1 file is deleted."
            elif [ "$delete" == "n" ] || [ "$delete" == "N" ]; then
               echo "Returning to the main screen..."
            else
               echo "Invalid choice!"
            fi
         done
      fi
   fi
}

while (true) do
echo "Please select an option: "
echo ""
echo "  1. Check for palindromes"
echo "  2. Move .c files"
echo "  3. Draw hallowed square"
echo "  4. Uppercase conversion"
echo "  5. Delete files"
echo "  6. Exit"
  read choice
  [[ $choice =~ ^[0-9]+$ ]] || { echo "Please enter a valid (e.g numerical) value."; continue; }
  if ((choice >= 1 && choice <= 6)); then
if [ $choice -eq 1 ]; then   #First programme
        echo "Please enter an input string: "
        read input1
      check_palindrome "$input1"
        echo
        echo "Enter for MAIN MENU"
        read menu
continue;
    fi
if [ $choice -eq 2 ]; then   #Second programme
        echo "You can enter a optional path argument if you wish:"
        read input2
        move_c_files_with_given_path "$input2"
        echo
        echo "Enter for MAIN MENU"
        read menu
    fi
if [ $choice -eq 3 ]; then  #Third programme
echo "Hello, its square creater"
echo "To create square we have 2 rules"
echo "First: first number should be bigger"
echo "Second: Difference between those 2 numbers must be even"

read -p "Enter first number: " num1
read -p "Enter second number: " num2

difference=$(( $num1 - $num2 ))
reminder=$(( $difference % 2 ))
echo "reminder is "$reminder" "
zero=0

    if [ $num2 -gt $num1 ]
then echo "First number should be bigger!"
fi
if [ $reminder = $zero  ]
then
        draw_hollow_square "$num1" "$num2"
    fi
#awk '{sub(/Va*/,"İstanbul")}1' try.txt > temp.txt && mv temp.txt try.txt

    fi
if [ $choice -eq 4 ]; then #Fourth Programmed
        echo "Hello this programme converts specified word/words to UPPERCASE."
        echo "You need to give a Wildcard like /ek*/ and a path, but the path is optional"
        echo ""

read -p "Enter the wildcard : " wildcard
read -p "Enter path or just enter: " path

echo "Wildcard : "$wildcard" path: "$path" "
        
    
        uppercase_Converter_Inside_A_File "$wildcard" "$path"

echo   ""
        echo "Enter for MAIN MENU"
        read menu
    fi
    if [ $choice -eq 5 ]; then
       printf "You can give an optional path argument if you wish. Use -R to run the program recursively: "
       while :; do
          read arg_1 arg_2
          if [ ! -z "$arg_1" ] && [ ! -z "$arg_2" ]; then
             [ -d $arg_1 ] && [ "$arg_2" == "-R" ] || { echo "Invalid arguments!"; continue; }
             delete_empty_files $arg_1 $arg_2
             break
          elif [ ! -z "$arg_1" ] && [ -z "$arg_2"]; then
             delete_empty_files $arg_1
             break
          else
             delete_empty_files
          fi
          break
       done
       echo "Enter for MAIN MENU"
             read menu
    fi
    if [ $choice -eq 6 ]; then
        echo "Exiting...";
        exit 1
    fi
  else
    echo "Invalid number, please try again with in range [1-6]."
  fi


done




