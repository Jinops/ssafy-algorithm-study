## 양식
- 주간 폴더명을 `week01` 형식으로 만들기
- 폴더 내 README파일을 만들고, 문제 및 풀이기간을 명시하기
- 출제 사이트 및 문제 번호로 폴더 만들기 ex) `BOJ_1012`, `SWEA_2806`
> 빈 폴더를 commit하는 방법: 폴더 내에 `.gitkeep` 파일 생성
- 코드 파일명은 `SWEA_2806_박진우.java` 형식으로 하기

## Branch 관리
- 문제 출제자가 주간 폴더, 문제별 폴더 및 README를 작성 시 Main에 바로 작성하기 
- **문제를 풀 때에는, Main에 바로 Commit하지 않고, 자기 Branch에서 하기**
- Branch 이름은 다음과 이름 초성으로 하기 `mhk, jwp, jyb, mhw, smy, hyl`
- 문제를 다 풀었을 때, Main Branch에 Merge Request 보내기

### How to

1. main branch를 최신으로 업데이트하기
```
git checkout main
git pull
```

2. 자기의 branch로 바꾸기
```
git checkout jwp
```
 - branch가 없을 때, -b 옵션을 넣으면 branch를 새로 생성
```
git checkout -b jwp
```

3. 자기 branch에 main의 내용을 merge 하기 (최신화)
```
git checkout jwp
```

4. 문제 모두 푼 후, 파일 add 및 commit 하기
```
git add .
git commit -m "커밋 내용"
```

5. 리모트 레포지토리의 자기 branch로 push하기
```
git push origin jwp
```

6. Pull requests - New pull reqest
<br><kbd><img width="229" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/8a51500d-6760-4c31-814c-2f5d6159c4cc"></kbd>

7. base: main, compare: 작업한 branch로 설정하여, Create pull reqest
<br><kbd><img width="739" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/45329720-5193-459d-ad27-b51b89db944f"></kbd>

8. 내용 간단하게 작성하고, Assignee를 해당 주 문제 출제자로 설정
<br><kbd><<img width="1009" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/a2c93f63-775a-4dcd-a789-e2550250246b"></kbd>

9. (문제 출제자) Pull Reqest 확인 후 Main에 Merge하기
<br><kbd><<img width="750" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/09531912-c64e-49d4-b8ce-795c370b4d29"></kbd>

10. 이후 다시 작업을 할 경우, 1~3번 과정을 통해 최신 내용을 갱신하기

> 참고) branch 목록 보는 방법: `git branch`
