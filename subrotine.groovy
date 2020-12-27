String getUsername(String firstname, String lastname){
    return firstname.toLowerCase() + lastname.toLowerCase();
}

assert getUsername("krishan", "Thisera") == "krishanthisera" : "Invalid"

println(getUsername("krishan", "Thisera"))