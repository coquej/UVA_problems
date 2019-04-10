import fileinput

file=fileinput.input()
lines=[]
for line in file: lines.append(line)
N=len(lines)

def winner(votes,candidates):
    deleted_cand=[]
    rounds=len(votes[0])
    while True:
        possible_delet=[]
        cand_votes=[0]*candidates
        total=0
        for vote in votes:
            for j in range(0,rounds):
                if int(vote[j])-1 not in deleted_cand:
                    cand_votes[int(vote[j])-1]+=1
                    total+=1
                    break
        minim=100
        maxim=-1
        for c in range(0,candidates):
            if c not in deleted_cand:
                if cand_votes[c]>maxim: maxim=cand_votes[c]
                if cand_votes[c]/total > 0.5: return [c]
                elif cand_votes[c]<=minim: 
                    if cand_votes[c]<minim:
                        minim=cand_votes[c]
                        possible_delet=[]
                    possible_delet.append(c)
        if maxim==minim: return [c for c in range(0,candidates) if c not in deleted_cand]
        deleted_cand=list(set(deleted_cand).union(possible_delet))
    return []


def votacion(i):
    numcand=int(lines[i])
    i+=1
    cand_name=[]
    votes=[]
    while numcand>0:
        numcand-=1
        cand_name.append(lines[i][:-1])
        i+=1
    while lines[i]!="\n":
        votes.append(lines[i].split())
        i+=1
        if i>=N: break

    x=winner(votes,len(cand_name))
    for c in x: print(cand_name[c])
    return i


if __name__ == "__main__":
    numcases=int(lines[0])
    i=2
    while numcases>0:
        numcases-=1
        i=votacion(i)
        if(numcases>0): print()
        i+=1



