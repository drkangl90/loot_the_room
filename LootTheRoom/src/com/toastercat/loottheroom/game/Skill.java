package com.toastercat.loottheroom.game;

public class Skill
{
    private int iSpecialization;

    private int iMajorSkill1;
    private int iMajorSkill2;
    private int iMajorSkill3;
    private int iMajorSkill4;
    private int iMajorSkill5;
    private int iMajorSkill6;

    // Skill
    private float  fEnergyWeapons;
    private float  fExplosives;
    private float  fGuns;
    private float  fMeleeWeapons;
    private float  fUnarmed;
    private float  fHeavyArmor;
    private float  fBarter;
    private float  fMedicine;
    private float  fRepair;
    private float  fSpeech;
    private float  fLightArmor;

    // Skill Modifier
    private float  fEnergyWeaponsModifier;
    private float  fExplosivesModifier;
    private float  fGunsModifier;
    private float  fMeleeWeaponsModifier;
    private float  fUnarmedModifier;
    private float  fHeavyArmorModifier;
    private float  fBarterModifier;
    private float  fMedicineModifier;
    private float  fRepairModifier;
    private float  fSpeechModifier;
    private float  fLightArmorModifier;

    // Skill Rates
    private double dEnergyWeaponsSkillRate;
    private double dExplosivesSkillRate;
    private double dGunsSkillRate;
    private double dMeleeWeaponsSkillRate;
    private double dUnarmedSkillRate;
    private double dHeavyArmorSkillRate;
    private double dBarterSkillRate;
    private double dMedicineSkillRate;
    private double dRepairSkillRate;
    private double dSpeechSkillRate;
    private double dLightArmorSkillRate;


    public Skill()
    {
        fEnergyWeapons = 15;
        fExplosives = 15;
        fGuns = 15;
        fMeleeWeapons = 15;
        fUnarmed = 15;
        fHeavyArmor = 15;
        fBarter = 15;
        fMedicine = 15;
        fRepair = 15;
        fSpeech = 15;
        fLightArmor = 15;
    }

    /**
     * resets the skill values to 0
     */
    public void resetSkillValueModifiers()
    {
        fEnergyWeaponsModifier = 0;
        fExplosivesModifier = 0;
        fGunsModifier = 0;
        fMeleeWeaponsModifier = 0;
        fUnarmedModifier = 0;
        fHeavyArmorModifier = 0;
        fBarterModifier = 0;
        fMedicineModifier = 0;
        fRepairModifier = 0;
        fSpeechModifier = 0;
        fLightArmorModifier = 0;
    }


    /**
     * resets the skill rates to 100%
     */
    public void resetSkillRates()
    {
        dEnergyWeaponsSkillRate = 1.00;
        dExplosivesSkillRate = 1.00;
        dGunsSkillRate = 1.00;
        dMeleeWeaponsSkillRate = 1.00;
        dUnarmedSkillRate = 1.00;
        dHeavyArmorSkillRate = 1.00;
        dBarterSkillRate = 1.00;
        dMedicineSkillRate = 1.00;
        dRepairSkillRate = 1.00;
        dSpeechSkillRate = 1.00;
        dLightArmorSkillRate = 1.00;
    }


    public void setSkillValueModifiers()
    {
        int aiElement = 0;
        int[] arMajorSkills = new int[6]; // Declare Major Skills Array that will be filled by aiMajorSkillX's;
        arMajorSkills[0]= iMajorSkill1;
        arMajorSkills[1]= iMajorSkill2;
        arMajorSkills[2]= iMajorSkill3;
        arMajorSkills[3]= iMajorSkill4;
        arMajorSkills[4]= iMajorSkill5;
        arMajorSkills[5]= iMajorSkill6;
        aiElement = arMajorSkills.length;

        while (aiElement > 0)
        {
            aiElement -= 1;
            // Combat
            if (arMajorSkills[aiElement] == 0)
            {
                fEnergyWeaponsModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 1)
            {
                fExplosivesModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 2)
            {
                fGunsModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 3)
            {
                fMeleeWeaponsModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 4)
            {
                fUnarmedModifier += 20;
            }
            // Armor
            else if (arMajorSkills[aiElement] == 5)
            {
                fHeavyArmorModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 6)
            {
                fLightArmorModifier += 20;
            }
            // Non-Combat
            else if (arMajorSkills[aiElement] == 7)
            {
                fBarterModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 8)
            {
                fMedicineModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 9)
            {
                fRepairModifier += 20;
            }
            else if (arMajorSkills[aiElement] == 10)
            {
                fSpeechModifier += 20;
            }
        }
    }

    public void ApplySkillValues()
    {
        // TODO Auto-generated method stub
        // get base skill and add modified
        fEnergyWeapons = fEnergyWeapons + fEnergyWeaponsModifier;
        fExplosives = fExplosives + fExplosivesModifier;
        fGuns = fGuns + fGunsModifier;
        fMeleeWeapons = fMeleeWeapons + fMeleeWeaponsModifier;
        fUnarmed = fUnarmed + fUnarmedModifier;
        fHeavyArmor = fHeavyArmor + fHeavyArmorModifier;
        fBarter = fBarter + fBarterModifier;
        fMedicine = fMedicine + fMedicineModifier;
        fRepair = fRepair + fRepairModifier;
        fSpeech = fSpeech + fSpeechModifier;
        fLightArmor = fLightArmor + fLightArmorModifier;
    }

    public void UnapplySkillValues()
    {
        // TODO Auto-generated method stub
        // get base skill and add modified
        fEnergyWeapons = fEnergyWeapons - fEnergyWeaponsModifier;
        fExplosives = fExplosives - fExplosivesModifier;
        fGuns = fGuns - fGunsModifier;
        fMeleeWeapons = fMeleeWeapons - fMeleeWeaponsModifier;
        fUnarmed = fUnarmed - fUnarmedModifier;
        fHeavyArmor = fHeavyArmor - fHeavyArmorModifier;
        fBarter = fBarter - fBarterModifier;
        fMedicine = fMedicine - fMedicineModifier;
        fRepair = fRepair - fRepairModifier;
        fSpeech = fSpeech - fSpeechModifier;
        fLightArmor = fLightArmor - fLightArmorModifier;
    }

    public void SpecializationSkillRate()
    {
        if (iSpecialization == 0) // Badass class
        {
            dMeleeWeaponsSkillRate += 0.05;
            dUnarmedSkillRate += 0.05;
            dHeavyArmorSkillRate += 0.05;
            dMedicineSkillRate += 0.05;
        }
        else if (iSpecialization == 1) // Inflicter
        {
            dGunsSkillRate += 0.05;
            dMeleeWeaponsSkillRate += 0.05;
            dLightArmorSkillRate += 0.05;
            dRepairSkillRate += 0.05;
        }
        else if (iSpecialization == 2) // Specialist
        {
            dEnergyWeaponsSkillRate += 0.05;
            dExplosivesSkillRate += 0.05;
            dLightArmorSkillRate += 0.05;
            dSpeechSkillRate += 0.05;
        }
        else if (iSpecialization ==3) // Destroyer
        {
            dEnergyWeaponsSkillRate += 0.05;
            dGunsSkillRate += 0.05;
            dHeavyArmorSkillRate += 0.05;
            dBarterSkillRate += 0.05;
        }
    }
}
