class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        
        def convertInt(string: str):
            digit = 0
            for c in string:
                digit = digit * 10 + (ord(c) - ord('0'))
            return digit
        
        return str(convertInt(num1) * convertInt(num2))


"""
    String -> int -> multiple wiht another int -> convert to string
    
    NO LIBRARIES -> INBUILT

    Conerting an string to an int:

"""