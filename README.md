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
- 문제를 다 풀었을 때, Main Branch에 MR 보내기

### 튜토리얼

1. 레포지토리 clone
```
git clone https://github.com/Jinops/ssafy-algorithm-study.git
```

2. 자기의 Branch로 바꾸기
```
git checkout "jwp
```
- branch가 없을 때, -b 옵션을 넣으면 branch를 새로 생성
```
git checkout -b "jwp"
```

3. 문제 모두 푼 후, 파일 add 및 commit 하기
```
git add .
```
```
git commit -m "커밋 내용"
```

4. 리모트 레포지토리의 자기 branch로 push하기
```
git push origin jwp
```

5. Pull requests - New pull reqest
<img width="229" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/8a51500d-6760-4c31-814c-2f5d6159c4cc">

6. base: main, compare: 작업한 branch로 설정하여, Create pull reqest
<img width="739" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/45329720-5193-459d-ad27-b51b89db944f">

7. 내용 간단하게 작성하고, Assignee를 해당 주 문제 출제자로 설정
<img width="1009" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/a2c93f63-775a-4dcd-a789-e2550250246b">

8. (문제 출제자) Pull Reqest 확인 후 Main에 Merge하기
<img width="750" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/09531912-c64e-49d4-b8ce-795c370b4d29">

9. remote에 반영된 내용 pull하기
```
git pull
```

