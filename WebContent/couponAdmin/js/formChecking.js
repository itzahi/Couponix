
//check if ob field is empty or not
  function isEmpty(ob)
  {
  	if(ob == null || ob == "")
  		{
  			return true;
  		}
  } 
  
  //check valid url function
  function isValidURL(url)
  {
    var RegExp = /^(https?:\/\/.*\.(?:png|jpg))/;

    if(RegExp.test(url))
    {
        return true;
    }
    else
    {
        return false;
    }
  } 
  //check valid string 
  function checkString(checking,ob) 
  {   
  	if(ob.match(checking))  
  	{  
  		return true;
  	}  
  	else  
  	{  
  		return false;
  	}  
  } 
