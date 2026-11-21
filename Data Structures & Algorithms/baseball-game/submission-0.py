class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        arr = [0, 0]

        for o in operations:
            if o == '+':
                stack.append(arr[0] + arr[1])

            elif o == 'C':
                stack.pop()

            elif o == 'D':
                stack.append(arr[1] * 2)

            else:
                stack.append(int(o))
                
            arr[1] = stack[-1] if len(stack) >= 1 else 0
            arr[0] = stack[-2] if len(stack) >= 2 else 0

        return sum(stack)


