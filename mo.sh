git filter-branch --commit-filter '
        if [ "$GIT_AUTHOR_NAME" = "Zephyrus" ];
        then
                GIT_AUTHOR_NAME="Zephyrus";
                GIT_AUTHOR_EMAIL="532329713@qq.com";
                git commit-tree "$@";
        else
                git commit-tree "$@";
        fi' HEAD