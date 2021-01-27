GIT은 분산 버전 관리 시스템(VCS, Version Control System)이다.

버전 관리란 이름 그대로 여러 파일을 하나의 버전으로 묶어 관리하는 것이다

### GIT의 필요성

여러 명이 팀을 구성하여 어떤 웹사이트 프로젝트를 진행하고 있다. <br>
내가 코드를 작성하고 저장한 다음 웹사이트의 'A' 페이지에 변경 부분을 업로드 한다. <br>
그런데 이때 팀원이 동시에 'A' 페이지에서 작업을 할 때 문제가 발생한다. <br>
만약 확인하지 않고 동시에 작업을 한다면 누군가의 작업은 겹체 쓰여질 것이고 지워질 것이기 때문이다. <br>
GIT은 이런 문제를 사전에 방지해준다. <br>
나와 동료는 같은 페이지에 각자 수정사항을 업로드 할 수 있고, 두개의 복사본을 저장한다. <br>

### GIT의 장점

1. 소스 코드를 주고 받을 필요 없이, 같은 파일을 여러 명이 동시에 작업하는 병렬 개발이 가능하다.<br>
(브랜치를 통해 개발한 뒤, 본 프로그램에서 합치는 방식(Merge)으로 개발을 진행할 수 있다.)

2. 분산 버전 관리이기 때문에 인터넷이 연결되지 않은 곳에서도 개발을 진행할 수 있고,<br> 중앙 저장소가 날라가 버려도 원상복구할 수 있다
   
3. 팀 프로젝트가 아닌, 개인 프로젝트일지라도 Git을 통해 버전 관리를 하면 체계적인 개발이 가능해지고, <br>프로그램이나 패치를 배포하는 과정도 간단해진다.
(pull을 통한 업데이트, patch로 파일 배포) 


### GIT 사용

1. 설치 확인 : git --version, 버전이 뜨지 않으면 git-scm.com에서 설치하기.
2. git init 으로 진행중인 프로젝트의 root 디렉토리에 가서 git 저장소 만들기
3. git status 로 현재 상태 확인하기

4. git add . 으로 Working Directory의 전체 파일을 스테이징 영역에 올리기
* 스테이징 영역은 GIT 로컬 저장소에 넣기 전에 대기시키는 곳
* .gitignore 파일로 로컬 저장소에 올리지 않을 것들을 지정해준다.
4. git commit -m "commit message" 로 로컬 저장소에 올린다.

5. git push 로 원격 저장소(Github)에 올리기


### GIT과 GITHUB 연동하기(SSH 설정)

1. Github에서 Repository 만들기
2. SSH 설정 확인하기

   1. 터미널 -> ls -a ~/.ssh   (만약 id_rsa, id_rsa.pub가 있으면 ssh 설정이 되어 있는 상태)

   2. GIT SSH 가이드 진행하기<br>
   [Generating a new SSH key](https://docs.github.com/en/github/authenticating-to-github/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent) 따라하기.

3. git remote add origin <name><url>
4. git push -u origin main
