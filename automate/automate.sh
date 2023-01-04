read -p "automate " nama nama2 nama3
mkdir -p "$nama at $(date)"/{my_friends,system_info,about_me}
mkdir -p "$nama at $(date)"/about_me/{personal,professional}
cd "$nama at $(date)"
touch about_me/personal/facebook.txt about_me/professional/linkedin.txt my_friends/list_of_my_friends.txt  system_info/about_this_laptop.txt system_info/internet_connection.txt
echo "https://www.facebook.com/$nama2" >> about_me/personal/facebook.txt 
echo "https://www.linkedin.com/in/$nama3" >> about_me/professional/linkedin.txt
echo -e $(curl https://gist.githubusercontent.com/tegarimansyah/e91f335753ab2c7fb12815779677e914/raw/94864388379fecee450fde26e3e73bfb2bcda194/list%2520of%2520my%2520friends.txt) >> my_friends/list_of_my_friends.txt 
echo -e "My username: $nama\nWith host:$(uname -a)" >> system_info/about_this_laptop.txt 
echo "$(ping -c 3 google.com)" >> system_info/internet_connection.txt 
cat about_me/personal/facebook.txt about_me/professional/linkedin.txt my_friends/list_of_my_friends.txt  system_info/about_this_laptop.txt system_info/internet_connection.txt



