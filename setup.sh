#!/bin/bash

oc create serviceaccount robot
oc adm policy add-role-to-user edit --serviceaccount robot