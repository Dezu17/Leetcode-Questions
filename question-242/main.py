def isAnagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    letters = {}
    for index in range(len(s)):
        if s[index] in letters:
            letters[s[index]] += 1
        else:
            letters[s[index]] = 1
    for index in range(len(t)):
        if t[index] in letters:
            letters[t[index]] -= 1
            if letters[t[index]] == 0:
                letters.pop(t[index])
        else:
            return False
    if not letters:
        return True
    return False

print(isAnagram("hell", "llh"))