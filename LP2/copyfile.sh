#!/bin/bash
SRC="$1"
DEST="$2"
MOD="$3"

if [ "$#" -lt 2 ]; then
    echo "Usage: $0 SRC DEST [-r], -r opcional"
    exit 1
fi
if [ "$MOD"="-r" ]; then
    scp -r "$SRC" "lpii09@152.92.236.14:/home/alunos/lp2//g09/$DEST"
else
    scp "$SRC" "lpii09@152.92.236.14:/home/alunos/lp2/g09/$DEST"
fi