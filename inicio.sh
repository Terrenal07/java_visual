#!/bin/bash
#autor: yo
#fecha: hoy

while true
do
	clear
	echo "MENU"
	echo "----"
	echo "(1) control de version"
	echo "(2) configurar usuario NOMBRE, EMAIL, PASSWORD"
	echo "(3) realizar commit"
	echo "(4) realizar commit sobre el ultimo"
	echo "(5) ---"
	echo "(6) ---"
	echo "(7) subir al repositorio remoto"
	echo "(8) ver commits"
	echo "(9) salir"
	echo
	echo -n "escriba opcion:"
	read opcion
	clear
		case $opcion in
	1)
		echo "control de version"
		echo "------------------"
		git init
		echo "------------------------------------------"
		echo "git iniciado"
		echo "------------------------------------------"
		echo "pulsa enter para continuar..."
		read
    ;;
	2)
		echo "configurar usuario NOMBRE, EMAIL, PASSWORD"
		echo "------------------------------------------"
		git config user.username "Terrenal07"
		git config user.email "ikerberme@gmail.com"
		git config user.password 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
		git remote add origin "https://github.com/Terrenal07/java_visual"
		git branch -M main
		cat .git/config
		echo "------------------------------------------"
		echo "archivo config configurado"
		echo "------------------------------------------"
		echo "pulsa enter para continuar..."
		read
    ;;
	3)
		echo "realizar el primer commit"
		echo "-------------------------"
		git add -A
		git commit -m "foto 1"
		echo "------------------------------------------"
		echo "commit"
		echo "------------------------------------------"
		echo "pulsa enter para continuar..."
		read
	;;
	4)
		echo "realizar commit sobre el ultimo"
		echo "-------------------------------"
		git add -A
		git commit --amend 
		echo "------------------------------------------"
		echo "commit"
		echo "------------------------------------------"
		echo "pulsa enter para continuar..."
		read
	;;
	5)
		echo "pulsa enter para continuar..."
		read
    ;;
	6)
		echo "pulsa enter para continuar..."
		read
    ;;
	7)
		echo "subir al repositorio remoto"
		echo "---------------------------"
		git push -u -f origin main
		echo "------------------------------------------"
		echo "repositorio subido"
		echo "------------------------------------------"
		echo "pulsa enter para continuar..."
		read
    ;;
	8)
		echo "ver commits"
		echo "-----------"
		git log
		echo "pulsa enter para continuar..."
		read
	;;
	9)
		echo "------------------------------------------"
		echo "saliendo del menu"
		echo "------------------------------------------"
		echo "pulsa enter para continuar..."
		read
		break
	;;
	*)
		echo "Opción no valida"
		echo "----------------"
		echo "pulsa enter para continuar..."
		read
	;;
esac
done
exit 0