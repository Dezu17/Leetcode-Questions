from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseList(head: Optional[ListNode]) -> Optional[ListNode]:
    length = 0
    copy = head
    while copy != None:
        length += 1
        copy = copy.next
    previous = None
    while head != None:
        copy = head.next
        head.next = previous
        previous = head
        head = copy
    return previous

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
result = reverseList(head)
while result != None:
    print(result.val)
    result = result.next