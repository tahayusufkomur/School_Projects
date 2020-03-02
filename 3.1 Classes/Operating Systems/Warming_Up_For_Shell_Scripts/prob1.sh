#!/bin/sh
#this is a programme detecting the          palindrome words***********************************



clear

str=$1
len=`echo $str | wc -c`  #getting the number of characters
len=`expr $len - 1` #len - 1
i=1
k=0
j=`expr $len / 2`  #len / 2
if test $j -le $k   #checking if the string valid
then
echo "This is not a valid string"
exit
fi

while test $i -le $j
do
k=`echo $str | cut -c $i`
l=`echo $str | cut -c $len`
if test $k != $l
then
echo "String is not palindrome"
exit
fi
i=`expr $i + 1`
len=`expr $len - 1`
done
echo "String is palindrome"
